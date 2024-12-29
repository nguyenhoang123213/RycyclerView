package com.example.rycyclerview.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rycyclerview.R;
import com.example.rycyclerview.data.source.StudentDataRepository;
import com.example.rycyclerview.data.source.local.LocalDataSource;
import com.example.rycyclerview.ui.adapter.StudentAdapter;
import com.example.rycyclerview.ui.viewmodel.StudentViewModel;
import com.example.rycyclerview.ui.viewmodel.StudentViewModelFactory;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private StudentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setupViews();
        setupViewModel();

    }


    private void setupViews() {
        RecyclerView recyclerView =findViewById(R.id.recycler_student);
        mAdapter = new StudentAdapter(null,student -> {
            String message= getString(R.string.message_info,student.getFullName());
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(mAdapter);
        DividerItemDecoration divider =
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        Drawable drawableDivider=Objects.requireNonNull(
                AppCompatResources.getDrawable(this, R.drawable.list_divider));
        divider.setDrawable(drawableDivider);
        recyclerView.addItemDecoration(divider);
    }

    private void setupViewModel() {
        LocalDataSource localDataSource=new LocalDataSource(this);
        StudentDataRepository repository=new StudentDataRepository(localDataSource);
        StudentViewModel viewModel = new ViewModelProvider(
                this,new StudentViewModelFactory(repository)).get(StudentViewModel.class);
        viewModel.student.observe(this,mAdapter::updateData);
    }
}
