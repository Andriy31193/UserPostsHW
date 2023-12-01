package edu.itstep.myapplic11.fragments.slider;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

import edu.itstep.myapplic11.interfaces.listeners.OnSlideClickListener;

public class SlideAdapter extends FragmentStateAdapter {
    private final List<Slide> slides;
    private final OnSlideClickListener listener;

    public SlideAdapter(@NonNull FragmentActivity fragmentActivity, List<Slide> slides, OnSlideClickListener listener) {
        super(fragmentActivity);
        this.slides = slides;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        SlideFragment sf = new SlideFragment(slides.get(position));

        sf.setListener(x -> listener.onClick(slides.get(position)));

        return sf;
    }

    @Override
    public int getItemCount() {
        return slides.size();
    }
}
