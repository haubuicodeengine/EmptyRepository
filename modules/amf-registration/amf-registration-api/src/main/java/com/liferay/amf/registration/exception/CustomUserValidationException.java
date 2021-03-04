/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.amf.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */

public class CustomUserValidationException extends PortalException {

	public CustomUserValidationException() {
	}

	public CustomUserValidationException(String msg) {
		super(msg);
	}

	public CustomUserValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CustomUserValidationException(Throwable cause) {
		super(cause);
	}

	public static class BlankFieldException extends CustomUserValidationException {

		public BlankFieldException(String outputError) {
			super(String.format(outputError));
		}
	}
	
	public static class FieldLengthException extends CustomUserValidationException {

		public FieldLengthException(String outputError) {
			super(String.format(outputError));
		}
	}
	
	public static class FieldValueUniqueException extends CustomUserValidationException {

		public FieldValueUniqueException(String outputError) {
			super(String.format(outputError));
		}
	}
	
	public static class UserAgeException extends CustomUserValidationException {

		public UserAgeException(String outputError) {
			super(String.format(outputError));
		}
	}
	
	public static class NumericValueException extends CustomUserValidationException {

		public NumericValueException(String outputError) {
			super(String.format(outputError));
		}
	}
}