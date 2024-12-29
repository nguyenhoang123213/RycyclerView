package com.example.rycyclerview.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rycyclerview.data.model.Student;
import com.example.rycyclerview.data.source.StudentDataRepository;

import java.util.List;

public class StudentViewModel extends ViewModel {
    private StudentDataRepository mRepository;
    private final MutableLiveData<List<Student>> mStudent = new MutableLiveData<>();
    public LiveData<List<Student>> student=mStudent;
    public StudentViewModel(StudentDataRepository repository){
        mRepository=repository;
        loadData();
    }

    private void loadData() {
        List<Student> result=mRepository.loadData();
        mStudent.setValue(result);
    }
}
