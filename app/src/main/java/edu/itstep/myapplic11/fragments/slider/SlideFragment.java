package edu.itstep.myapplic11.fragments.slider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.itstep.myapplic11.interfaces.listeners.OnSlideClickListener;
import edu.itstep.myapplic11.R;

public class SlideFragment extends Fragment {
    private final Slide slide;
    private OnSlideClickListener listener;

    public SlideFragment(Slide slide) {
        super(R.layout.fragment_slide);
        this.slide = slide;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TextView tvPostAuthor = view.findViewById(R.id.tvPostAuthor);
        TextView tvPostId = view.findViewById(R.id.tvPostId);
        TextView tvHeader = view.findViewById(R.id.tvHeader);
        TextView tvParagraph = view.findViewById(R.id.tvParagraph);

        tvPostAuthor.setText(getString(R.string.user_id) + slide.getPost().getUserId());
        tvPostId.setText(getString(R.string.post) + slide.getPost().getId());
        tvHeader.setText(slide.getHeader());
        tvParagraph.setText(slide.getParagraph());
        view.setBackgroundColor(slide.getColor());



        view.setOnClickListener(x -> listener.onClick(slide));

    }

    public void setListener(OnSlideClickListener listener) {
        this.listener = listener;
    }
}
