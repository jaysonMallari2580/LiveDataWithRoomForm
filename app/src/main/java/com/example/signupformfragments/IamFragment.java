package com.example.signupformfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.signupformfragments.databinding.FragmentIamBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IamFragment extends Fragment {

    private FragmentIamBinding binding;
    private String gender = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_iam,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(gender!= ""){
            binding.continueButtonMyIam.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color));
            binding.continueButtonMyIam.setEnabled(true);
        }

        binding.womanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender =  "Woman";
                binding.womanButton.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color));
                binding.continueButtonMyIam.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color));
                binding.continueButtonMyIam.setEnabled(true);
            }
        });

        binding.manButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender ="Man";
                binding.manButton.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color));
                binding.continueButtonMyIam.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color));
                binding.continueButtonMyIam.setEnabled(true);
            }
        });

        binding.continueButtonMyIam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(requireParentFragment()).navigate(R.id.destination_school_fragment);
            }
        });
    }

    private void returnToBirthdayFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_gender_fragment_pop);
    }

    public static IamFragment newInstance(){
        return new IamFragment();
    }
}