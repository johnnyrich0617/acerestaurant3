package edu.snhu633.jhrichardson.ace.recycler.restaurant.layout.manager;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * This class is used as an extension to the GridLayoutManager
 * to auto fit its children.  We really only need this so to override the
 * default children layout of the GridLayoutManager
 *
 * @author jhrichardson
 * @see androidx.recyclerview.widget.GridLayoutManager
 */

public class AutoFitGridLayoutManager extends GridLayoutManager {

    private int columnWidth;
    private boolean columnWidthChanged = true;

    public AutoFitGridLayoutManager(Context context, int columnWidth) {
        super(context, 1);
        setColumnWidth(columnWidth);
    }

    /**
     * Set the column width when changed
     * @param newColumnWidth the changed column width
     */
    public void setColumnWidth(int newColumnWidth) {
        if (newColumnWidth > 0 && newColumnWidth != columnWidth) {
            columnWidth = newColumnWidth;
            columnWidthChanged = true;
        }
    }

    /**
     * Calculate the new layout of children based on space available in the view
     * @param recycler  the changes in the view
     * @param state the changed state of the view
     * @see androidx.recyclerview.widget.RecyclerView
     */
    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (columnWidthChanged && columnWidth > 0) {
            int totalSpace;
            if (getOrientation() == VERTICAL) {
                totalSpace = getWidth() - getPaddingRight() - getPaddingLeft();
            } else {
                totalSpace = getHeight() - getPaddingTop() - getPaddingBottom();
            }
            int spanCount = Math.max(1, totalSpace / columnWidth);
            setSpanCount(spanCount);
            columnWidthChanged = false;
        }
        super.onLayoutChildren(recycler, state);
    }
}
