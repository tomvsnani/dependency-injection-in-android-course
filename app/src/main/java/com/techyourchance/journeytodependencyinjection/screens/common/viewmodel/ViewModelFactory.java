package com.techyourchance.journeytodependencyinjection.screens.common.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionDetailsUseCase;
import com.techyourchance.journeytodependencyinjection.screens.questiondetails.QuestionDetailsViewModel;
import com.techyourchance.journeytodependencyinjection.screens.questionslist.QuestionsListViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final QuestionDetailsViewModel mQuestionDetailsViewModel;
    private final QuestionsListViewModel mQuestionsListViewModel;

    public ViewModelFactory(QuestionDetailsViewModel questionDetailsViewModel,
                            QuestionsListViewModel questionsListViewModel) {
        mQuestionDetailsViewModel = questionDetailsViewModel;
        mQuestionsListViewModel = questionsListViewModel;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        ViewModel viewModel;
        if (modelClass == QuestionDetailsViewModel.class) {
            viewModel = mQuestionDetailsViewModel;
        }
        else if (modelClass == QuestionsListViewModel.class) {
            viewModel = mQuestionsListViewModel;
        }
        else {
            throw new RuntimeException("invalid view model class: " + modelClass);
        }

        return (T) viewModel;
    }
}
