/******************************************************************************* 
 * Copyright (c) 2016 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/ 
package org.jboss.reddeer.uiforms.impl.form;

import org.eclipse.swt.widgets.Control;
import org.hamcrest.Matcher;
import org.jboss.reddeer.core.reference.ReferencedComposite;
import org.jboss.reddeer.swt.widgets.AbstractControl;
import org.jboss.reddeer.uiforms.api.Form;
import org.jboss.reddeer.uiforms.handler.FormHandler;

/**
 * Common ancestor for all {@link Form} implementations. 
 * 
 * @author Lucia Jelinkova
 *
 */
public abstract class AbstractForm extends AbstractControl<org.eclipse.ui.forms.widgets.Form> implements Form {

	protected AbstractForm(ReferencedComposite refComposite, int index, Matcher<?>... matchers){
		super(org.eclipse.ui.forms.widgets.Form.class, refComposite, index, matchers);
		setFocus();
	}
	
	protected AbstractForm(org.eclipse.ui.forms.widgets.Form widget){
		super(widget);
	}
	
	@Override
	public Control getControl() {
		return swtWidget.getBody();
	}
	
	public String getText(){
		return FormHandler.getInstance().getText(swtWidget);
	}
}
