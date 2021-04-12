package com.example.signupformfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.signupformfragments.databinding.FragmentMySchoolBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MySchoolFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MySchoolFragment extends Fragment {

    private FragmentMySchoolBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_my_school,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.schoolTextInput.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.continueButtonMySchool.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color));
                binding.continueButtonMySchool.setEnabled(true);
            }
        });

        binding.continueButtonMySchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(requireParentFragment()).navigate(R.id.destination_profile_fragment);
            }
        });

    }

    private void returnToGenderFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_school_fragment_pop);
    }

    public static MySchoolFragment newInstance(){
        return new MySchoolFragment();
    }
}