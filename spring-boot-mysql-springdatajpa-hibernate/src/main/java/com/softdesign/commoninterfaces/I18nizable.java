package com.softdesign.commoninterfaces;

/**
 * Use the {@link I18nizable} interface to indicate that your class has an I18n key defined in a translation
 * dictionnaries (e.g the MyLanguage.properties).
 *
 */
public interface I18nizable
{

	/**
	 * A string value that uniquely identifies a key in a translation dictionnary.
	 * @return a i18n key
	 */
	String getI18nKey();
}
