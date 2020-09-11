package androidx.constraintlayout.solver.widgets;

import java.util.Arrays;
import java.util.HashMap;

/**
 * HelperWidget class
 */
public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] mWidgets = new ConstraintWidget[4];
    public int mWidgetsCount = 0;

    @Override
    public void updateConstraints(ConstraintWidgetContainer container) {
        // nothing here
    }

    /**
     * Add a widget to the helper
     *
     * @param widget a widget
     */
    public void add(ConstraintWidget widget) {
        if (widget == this || widget == null) {
            return;
        }
        if (mWidgetsCount + 1 > mWidgets.length) {
            mWidgets = Arrays.copyOf(mWidgets, mWidgets.length * 2);
        }
        mWidgets[mWidgetsCount] = widget;
        mWidgetsCount++;
    }

    @Override
    public void copy(ConstraintWidget src, HashMap<ConstraintWidget,ConstraintWidget> map) {
        super.copy(src, map);
        HelperWidget srcHelper = (HelperWidget) src;
        mWidgetsCount = 0;
        final int count = srcHelper.mWidgetsCount;
        for (int i = 0; i < count; i++) {
            add(map.get(srcHelper.mWidgets[i]));
        }
    }

    /**
     * Reset the widgets list contained by this helper
     */
    public void removeAllIds() {
        mWidgetsCount = 0;
        Arrays.fill(mWidgets, null);
    }
}