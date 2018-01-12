/*
 *     Spruce
 *
 *     Copyright (c) 2017 WillowTree, Inc.
 *     Permission is hereby granted, free of charge, to any person obtaining a copy
 *     of this software and associated documentation files (the "Software"), to deal
 *     in the Software without restriction, including without limitation the rights
 *     to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *     copies of the Software, and to permit persons to whom the Software is
 *     furnished to do so, subject to the following conditions:
 *     The above copyright notice and this permission notice shall be included in
 *     all copies or substantial portions of the Software.
 *     THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *     IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *     FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *     AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *     LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *     OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *     THE SOFTWARE.
 *
 */

package com.jaja.zspruce;

import android.view.View;
import android.view.ViewGroup;

import com.jaja.zspruce.widget.SpruceTimedView;

import java.util.ArrayList;
import java.util.List;

public class DefaultSort extends SortFunction {

    private final long interObjectDelay;

    /**
     * Default sort; handles views with a provided offset delay
     * @param interObjectDelay (long) delay between object animations
     */
    public DefaultSort(long interObjectDelay) {
        this.interObjectDelay = interObjectDelay;
    }

    @Override
    public List<SpruceTimedView> getViewListWithTimeOffsets(ViewGroup parent, List<View> children) {
        List<SpruceTimedView> childTimedViews = new ArrayList<>();
        long currentTimeOffset = 0L;

        for (View childView : children) {
            childTimedViews.add(new SpruceTimedView(childView, currentTimeOffset));
            currentTimeOffset += interObjectDelay;
        }

        return childTimedViews;
    }

    @Override
    public void sortChildren(ViewGroup parent, List<View> children) {
        // Do nothing, as the original order is maintained
    }
}
