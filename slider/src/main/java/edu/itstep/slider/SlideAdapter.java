package edu.itstep.slider;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class SlideAdapter extends FragmentStateAdapter {
    private List<Slide> slides;

    public SlideAdapter(@NonNull FragmentActivity fragmentActivity, List<Slide> slides) {
        super(fragmentActivity);
        this.slides = slides;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new SlideFragment(slides.get(position));
    }

    @Override
    public int getItemCount() {
        return slides.size();
    }
}
