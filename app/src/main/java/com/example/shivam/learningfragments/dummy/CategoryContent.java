package com.example.shivam.learningfragments.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shivam on 26/11/17.
 */

public class CategoryContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<CategoryItem> CATEGORY_ITEMS = new ArrayList<CategoryItem>();
    public static final ArrayList<CategoryItem> CATEGORY_ITEMS_D = new ArrayList<CategoryItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, CategoryItem> ITEM_MAP = new HashMap<String, CategoryItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createCategoryItem(i));
        }
    }

    private static void addItem(CategoryItem item) {
        CATEGORY_ITEMS.add(item);
        CATEGORY_ITEMS_D.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static CategoryItem createCategoryItem(int position) {
        //Currently we are setting every value to false...It can be toggled later
        return new CategoryItem(String.valueOf(position), "Category " + position,false);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class CategoryItem {
        public final String id;
        public final String content;
        public boolean isActive;

        public String getId() {
            return id;
        }

        public String getContent() {
            return content;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public CategoryItem(String id, String content, boolean isActive) {
            this.id = id;
            this.content = content;
            this.isActive = isActive;

        }

        @Override
        public String toString() {
            return content;
        }
    }
}
