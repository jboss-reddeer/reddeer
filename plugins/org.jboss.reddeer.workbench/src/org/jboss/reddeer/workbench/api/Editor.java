package org.jboss.reddeer.workbench.api;

import java.util.List;

import org.jboss.reddeer.eclipse.jface.text.contentassist.ContentAssistant;

/**
 * Interface with base operations which can be performed with editor.
 * 
 * @author rhopp
 * @author rawagner
 */
public interface Editor extends WorkbenchPart {

	/**
	 * 
	 * @return editor title
	 */
	String getTitle();

	/**
	 * 
	 * @return editor title tooltip
	 */
	String getTitleToolTip();

	/**
	 * Checks if editor is dirty
	 * 
	 * @return true if editor is dirty
	 */
	boolean isDirty();

	/**
	 * Tries to perform save on this editor.
	 */
	void save();

	/**
	 * Closes this editor
	 * 
	 * @param save
	 *            If true, content will be saved
	 */
	void close(boolean save);

	/**
	 * Checks if editor is active
	 * 
	 * @return whether is this editor currently active and has focus.
	 */
	boolean isActive();

	/**
	 * Opens content assistant
	 */
	ContentAssistant openContentAssistant();

	/**
	 * Opens quickfix content assistant
	 */
	ContentAssistant openQuickFixContentAssistant();

	/**
	 * Opens open on assistant
	 */
	ContentAssistant openOpenOnAssistant();

	/**
	 * Returns editor validation markers
	 * 
	 * @returns editor validation markers
	 */
	List<String> getMarkers();

}
