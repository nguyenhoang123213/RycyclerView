package com.example.rycyclerview.data.source.local;

import android.content.Context;

import com.example.rycyclerview.R;
import com.example.rycyclerview.data.model.Student;
import com.example.rycyclerview.data.source.StudentDataSource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocalDataSource implements StudentDataSource {
    private final Context mContext;
    public LocalDataSource(Context context){
        mContext=context;
    }
    @Override


    public List<Student> loadData() {
        String jsonString=getJsonString();
        ObjectMapper mapper=new ObjectMapper();
        try{
            return mapper.readValue(jsonString, new TypeReference<List<Student>>() {

            });
        }catch (JsonProcessingException ignored){
            return new ArrayList<>();
        }

    }

    private String getJsonString() {
        Writer writer =new StringWriter();
        char[] buffer = new char[1024];
        try(InputStream inputStream=
                mContext.getResources().openRawResource(R.raw.student)){
Reader reader =
        new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
int size;
while((size=reader.read(buffer)) !=-1){
    writer.write(buffer,0,size);
}
        }catch(IOException ignored){

        }
        return writer.toString();
    }
}
