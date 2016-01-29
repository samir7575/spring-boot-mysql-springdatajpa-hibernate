package com.softdesign.commoninterfaces;

/**
 * An interface that indicates that a class is identifiable by an unique code, understandable (explicitly readable) by
 * human (of the given parameterized type 'CODE').
 * @param <CODE> the unique code type. A code is always explicitly readable by human. != HasID.
 * @author malek
 *
 */
public interface HasCode<CODE>
{
	CODE getCode();
}
