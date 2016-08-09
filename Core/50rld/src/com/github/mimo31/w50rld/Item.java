package com.github.mimo31.w50rld;

import java.awt.Graphics2D;

/**
 * Represents an Item in some kind of inventory. Its subclasses are intended to only be instantiated once during the game - when loading indexes.
 * @author mimo31
 *
 */
public abstract class Item {

	// name of the Item
	public final String name;
	
	// action that can be performed with the Item
	public final ItemAction[] actions;
	
	/**
	 * Draws the Item.
	 * @param g graphics to draw through
	 * @param x x coordinate of the location to draw
	 * @param y y coordinate of the location to draw
	 * @param width width of the rectangle to draw
	 * @param height height of the rectangle to draw
	 */
	public abstract void draw(Graphics2D g, int x, int y, int width, int height);

	public Item(String name, ItemAction[] actions)
	{
		this.name = name;
		this.actions = actions;
	}
	
	/**
	 * Represent an action that can be done with an Item.
	 * @author mimo31
	 *
	 */
	public static abstract class ItemAction {
		
		// name of the action
		public final String name;
		
		public ItemAction(String name)
		{
			this.name = name;
		}
		
		/**
		 * Determines whether the action can be applied on a specific Tile.
		 * @param tileX x coordinate of the Tile
		 * @param tileY y coordinate of the Tile
		 * @return whether the action can be applied
		 */
		public boolean actionPredicate(int tileX, int tileY)
		{
			return true;
		}

		/**
		 * The method to invoke when this action is chosen.
		 * @param tileX x coordinate of the Tile to apply the action to
		 * @param tileY y coordinate of the Tile to apply the action to
		 * @return whether the Item should be removed after this action
		 */
		public abstract boolean action(int tileX, int tileY);
		
	}
}

