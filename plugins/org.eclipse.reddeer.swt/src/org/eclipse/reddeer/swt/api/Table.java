/*******************************************************************************
 * Copyright (c) 2017, 2018 Red Hat, Inc and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Red Hat, Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.reddeer.swt.api;

import java.util.List;

import org.hamcrest.Matcher;
import org.eclipse.reddeer.core.reference.ReferencedComposite;

/**
 * API for table manipulation.
 * 
 * @author Jiri Peterka
 *
 */
public interface Table extends Control<org.eclipse.swt.widgets.Table>, ReferencedComposite {

	/**
	 * Returns true if table contains item with specified text.
	 * 
	 * @param item text of the item to find
	 * @return true if table contains item with the specified name, false otherwise
	 */
	boolean containsItem(String item);

	/**
	 * Returns whether the table contains item with specified text in given cell or not.
	 * 
	 * @param item item to find at specific position
	 * @param cellIndex index of the cell where to look for item
	 * @return true if the table contains specified item, false otherwise
	 */
	boolean containsItem(String item, int cellIndex);

	/**
	 * Returns table row count.
	 * 
	 * @return row count of the table
	 */
	int rowCount();

	/**
	 * Selects rows with specified indices.
	 * 
	 * @param indices indices row indices to select
	 */
	void select(int... indices);

	/**
	 * Selects rows with items with specified texts.
	 * 
	 * @param items texts of items to select
	 */
	void select(String... items);

	/**
	 * Selects all table items.
	 */
	void selectAll();

	/**
	 * Deselects all table items.
	 */
	void deselectAll();

	/**
	 * Returns item in specific row.
	 * 
	 * @param row index of the row
	 * @return table item in the specified row
	 */
	TableItem getItem(final int row);

	/**
	 * Returns item with specified text.
	 * 
	 * @param itemText text of the item to get
	 * @return table item with the specified text
	 */
	TableItem getItem(final String itemText);

	/**
	 * Returns all table items.
	 * 
	 * @return list of all table items
	 */
	List<TableItem> getItems();

	/**
	 * Returns item with specified text and column.
	 * 
	 * @param itemText text of the item to get
	 * @param column column where the item is located
	 * @return table item at specified text and column
	 */
	TableItem getItem(final String itemText, int column);

	/**
	 * Returns index of specified table item. 
	 *
	 * @param tableItem item to find out its index
	 * @return index of specified table item
	 */
	int indexOf(TableItem tableItem);

	/**
	 * Gets headers of a table as list of their labels.
	 * 
	 * @return list of headers of a table
	 */
	List<String> getHeaders();
	
	/**
	 * Gets header placed on the specified index in table.
	 * @param index index of desired header
	 * @return label of header
	 */
	String getHeader(int index);
	
	/**
	 * Gets index of a specified header in table.
	 * If there is no such header, method throws
	 * SWTLayerException.
	 * 
	 * @param header header to find out its index
	 * @return index of a specified header
	 */
	int getHeaderIndex(String header);
	
	/**
	 * Returns table items matching the matcher.
	 * 
	 * @param matchers array of matchers for items matching
	 * @return table items matching the matcher
	 */
	@SuppressWarnings("unchecked")
	List<TableItem> getItems(Matcher<TableItem>... matchers);
	
	/**
	 * Returns table items matching the strings in columns(fixed order).
	 * Returns empty array, if array of string is longer than number of columns.
	 * If array of strings is shorter, then returns all matching TableItems. 
	 * 
	 * @param tableTexts array of strings for items matching
	 * @return table items matching the strings in columns
	 */
	List<TableItem> getItems(String... tableTexts);
	
	/**
	 * Gets currently selected table items.
	 * 
	 * @return list of selected table items
	 */
	List<TableItem> getSelectedItems();

	/**
	 * @deprecated As of 2.1.0 because of typo in method name.
	 * Use {@link #getSelectedItems()} instead.
	 *
	 */
	@Deprecated
	List<TableItem> getSelectetItems();
}
