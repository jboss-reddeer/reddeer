package org.jboss.reddeer.swt.impl.button;

import org.eclipse.swt.SWT;
import org.hamcrest.Matcher;
import org.jboss.reddeer.common.logging.Logger;
import org.jboss.reddeer.core.handler.ButtonHandler;
import org.jboss.reddeer.core.matcher.WithMnemonicTextMatcher;
import org.jboss.reddeer.core.reference.ReferencedComposite;
/**
 * Class represents Button with type Toggle (Checkbox)
 * 
 * @author rhopp
 * 
 */

public class CheckBox extends AbstractButton {

	private static final Logger log = Logger.getLogger(CheckBox.class);
	
	/**
	 * Checkbox with index 0
	 */
	public CheckBox() {
		this((ReferencedComposite) null);
	}
	
	/**
	 * Checkbox inside given referencedComposite
	 * @param referencedComposite
	 */
	public CheckBox(ReferencedComposite referencedComposite) {
		this(referencedComposite, 0);
	}
	
	/**
	 * Checkbox with given text
	 * 
	 * @param text
	 */
	public CheckBox(String text) {
		this(null, text);
	}
	
	/**
	 * Checkbox that matches given matchers
	 * @param matchers
	 */
	public CheckBox(Matcher<?>... matchers) {
		this(null, matchers);
	}
	
	/**
	 * Checkbox that matches given matchers
	 * @param referencedComposite
	 * @param matchers
	 */
	public CheckBox(ReferencedComposite referencedComposite, Matcher<?>... matchers) {
		this(referencedComposite, 0, matchers);
	}
	
	/**
	 * Checkbox with given text inside given referencedComposite
	 * @param referencedComposite
	 * @param text
	 */
	public CheckBox(ReferencedComposite referencedComposite,String text) {
		this(referencedComposite, 0, new WithMnemonicTextMatcher(text));
	}
	
	/**
	 * Checkbox with given index that matches given matchers
	 * 
	 * @param index
	 * @param matchers
	 */
	public CheckBox(int index, Matcher<?>... matchers){
		this(null, index, matchers);
	}
	
	/**
	 * Checkbox with given index inside given referencedComposite that matches given matchers
	 * @param referencedComposite
	 * @param index
	 * @param matchers
	 */
	public CheckBox(ReferencedComposite referencedComposite, int index, Matcher<?>... matchers){
		super(referencedComposite, index, SWT.CHECK, matchers);
	}
	
	/**
	 * Returns true when Check Box is checked
	 * @return
	 */
	public boolean isChecked() {
		return ButtonHandler.getInstance().isSelected(swtWidget);
	}
	
	/**
	 * Sets checkbox to state 'checked'
	 * 
	 * @param checked
	 */
	public void toggle(boolean checked){
		log.info("Select checkbox " + getDescriptiveText());
		if (checked){
			if (isChecked()) {
				log.debug("Checkbox " + getDescriptiveText() + " already selected, no action performed");
				return;
			}else{
				log.info("Check checkbox " + getDescriptiveText());
				click();
			}
		}else{
			if (isChecked()) {
				log.info("Uncheck checkbox " + getDescriptiveText());
				click();
			}else{
				log.debug("Checkbox " + getDescriptiveText() + " not checked, no action performed");
				return;
			}
		}
	}
}
