/*******************************************************************************
 * Copyright (c) 2017 Red Hat, Inc and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Red Hat, Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.reddeer.common.userprofile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Handles User Profile logic
 * @author vlado pakan
 *
 */
public class UserProfile {
	
	public static final String VM_ARGS_KEY = "vmArgs";
	public static final String PROGRAM_ARGS_KEY = "programArgs";
	private Properties userProfileProps = null;
	private static UserProfile userProfile = null;
	
	private UserProfile() {
		File userProfileFile = new File(System.getProperty("user.home"), ".reddeer");
		if (userProfileFile.exists()) {
			System.out.println("Loading RedDeer properties from user profile file: " + userProfileFile.getAbsolutePath());
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(userProfileFile);
				userProfileProps = new Properties();
				userProfileProps.load(fis);
			} catch (IOException ioe) {
				System.err.println("Error while loading RedDeer properties from user profile file: " + userProfileFile.getAbsolutePath());
				ioe.printStackTrace();
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException ioe) {
						System.err.println("Error while loading RedDeer properties from user profile file: " + userProfileFile.getAbsolutePath());
						ioe.printStackTrace();
					}
				}
			}
		}
	}
	
	/**
	 * Returns UserProfile instance .
	 *
	 * @return single instance of UserProfile
	 */
	public static UserProfile getInstance(){
		if (UserProfile.userProfile == null){
			UserProfile.userProfile = new UserProfile();
		}
		return UserProfile.userProfile;
	}
	
	/**
	 * Returns property value specified by key parameter if exists in use profile file
	 * otherwise returns null.
	 *
	 * @param key the key
	 * @return the property
	 */
	public String getProperty (String key){
		String value = null;
		if(userProfileProps != null	&& userProfileProps.containsKey(key)){
			value = userProfileProps.getProperty(key);
		}
		return value;
	}

}
