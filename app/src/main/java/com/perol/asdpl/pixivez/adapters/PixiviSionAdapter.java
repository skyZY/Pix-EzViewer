/*
 * MIT License
 *
 * Copyright (c) 2019 Perol_Notsfsssf
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE
 */

package com.perol.asdpl.pixivez.adapters;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.perol.asdpl.pixivez.R;
import com.perol.asdpl.pixivez.responses.SpotlightResponse;
import com.perol.asdpl.pixivez.services.GlideApp;

import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class PixiviSionAdapter extends BaseQuickAdapter<SpotlightResponse.SpotlightArticlesBean, BaseViewHolder> {
    private Context context;

    public PixiviSionAdapter(int layoutResId, @Nullable List<SpotlightResponse.SpotlightArticlesBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
        this.openLoadAnimation(BaseQuickAdapter.SCALEIN);
    }

    @Override
    protected void convert(BaseViewHolder helper, SpotlightResponse.SpotlightArticlesBean item) {
        helper.setText(R.id.textView__pixivision_title, item.getTitle()).addOnClickListener(R.id.imageView_pixivision);
        ImageView imageView = helper.getView(R.id.imageView_pixivision);

        GlideApp.with(context).load(item.getThumbnail()).transition(withCrossFade()).into(imageView);

    }
}
