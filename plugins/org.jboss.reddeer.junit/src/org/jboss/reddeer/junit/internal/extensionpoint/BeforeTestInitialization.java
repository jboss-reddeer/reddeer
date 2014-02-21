package org.jboss.reddeer.junit.internal.extensionpoint;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.jboss.reddeer.junit.extensionpoint.IBeforeTest;
import org.jboss.reddeer.junit.logging.Logger;
/**
 * Handles Initialization of all Before Test extensions
 * Has to be separate class because it's using eclipse libraries
 * and will not run for normal pure JUnit tests
 * @author vlado pakan
 */
public class BeforeTestInitialization {
	private static final Logger log = Logger.getLogger(BeforeTestInitialization.class);
	/**
	 * Initializes all Before Test extensions
	 */
	public static List<IBeforeTest> initialize(){
		final String beforeTestExtensionID = "org.jboss.reddeer.junit.before.test";
		LinkedList<IBeforeTest> beforeTestExts = new LinkedList<IBeforeTest>();
		IConfigurationElement[] configElements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(beforeTestExtensionID);
		try {
			log.debug("Number of found extensions for extension point " + beforeTestExtensionID + "="
				+ configElements.length);
			for (IConfigurationElement e : configElements) {
				final Object object = e.createExecutableExtension("class");
				if (object instanceof IBeforeTest) {
					beforeTestExts.add((IBeforeTest)object);
				}
				else{
					log.warn("Invalid class used for extension point " + beforeTestExtensionID
						+ ":" + object.getClass());
				}
			}
		} catch (CoreException ex) {
			log.error(
					"Error when processing extension for org.jbossreddeer.junit.before.test",
					ex.getMessage());
		}
		
		return beforeTestExts;
	}
}
