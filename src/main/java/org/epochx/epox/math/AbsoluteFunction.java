/*
 * Copyright 2007-2011 Tom Castle & Lawrence Beadle
 * Licensed under GNU Lesser General Public License
 * 
 * This file is part of EpochX: genetic programming software for research
 * 
 * EpochX is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * EpochX is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with EpochX. If not, see <http://www.gnu.org/licenses/>.
 * 
 * The latest version is available from: http://www.epochx.org
 */
package org.epochx.epox.math;

import org.epochx.epox.Node;
import org.epochx.tools.util.*;

/**
 * A function node which performs the mathematical absolute function, called
 * ABS.
 * 
 * The absolute function can be performed on inputs of the following types:
 * <ul>
 * <li>Integer</li>
 * <li>Long</li>
 * <li>Float</li>
 * <li>Double</li>
 * </ul>
 */
public class AbsoluteFunction extends Node {

	/**
	 * Constructs an AbsoluteFunction with one <code>null</code> child.
	 */
	public AbsoluteFunction() {
		this(null);
	}

	/**
	 * Constructs an AbsoluteFunction with one numerical child node.
	 * 
	 * @param child the child node.
	 */
	public AbsoluteFunction(final Node child) {
		super(child);
	}

	/**
	 * Evaluates this function. The child node is evaluated, the
	 * result of which must be a numeric type (one of Double, Float, Long,
	 * Integer). The result will be a positive value of equal magnitude to the
	 * child value. The return type will also be the same as the input type.
	 */
	@Override
	public Object evaluate() {
		final Object c = getChild(0).evaluate();

		final Class<?> returnType = TypeUtils.getNumericType(c.getClass());

		if (returnType == Double.class) {
			// Perform absolute on double.
			return Math.abs(NumericUtils.asDouble(c));
		} else if (returnType == Float.class) {
			// Perform absolute on float.
			return Math.abs(NumericUtils.asFloat(c));
		} else if (returnType == Long.class) {
			// Perform absolute on long.
			return Math.abs(NumericUtils.asLong(c));
		} else if (returnType == Integer.class) {
			// Perform absolute on integer.
			return Math.abs(NumericUtils.asInteger(c));
		}

		return null;
	}

	/**
	 * Returns the identifier of this function which is ABS.
	 */
	@Override
	public String getIdentifier() {
		return "ABS";
	}

	/**
	 * Returns this function node's return type for the given child input types.
	 * If there is one input type of a numeric type then the return type will
	 * be that same numeric type. In all other cases this method will return
	 * <code>null</code> to indicate that the inputs are invalid.
	 * 
	 * @return A numeric class or null if the input type is invalid.
	 */
	@Override
	public Class<?> getReturnType(final Class<?> ... inputTypes) {
		if (inputTypes.length == 1) {
			return TypeUtils.getNumericType(inputTypes);
		}
		return null;
	}
}
