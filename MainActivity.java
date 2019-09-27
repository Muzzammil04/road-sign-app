package com.example.question3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import  java.util.Random;

public class MainActivity extends AppCompatActivity {
ImageView image;
Button confirm_question,one,two,three;
TextView question,wrong1,correct1,option1,option2,option3,result;
EditText no_question;
int correct=0;
int wrong=0;
String answer=new String();
int id=0;
int number=0,counter=0;

ArrayList<ImageQuestion>content=new ArrayList<ImageQuestion>();
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
 no_question=(EditText)findViewById(R.id.no_question);
 confirm_question=(Button)findViewById(R.id.confirm_number);
    image=(ImageView)findViewById(R.id.image);
 question=(TextView)findViewById(R.id.question);
 option1=(TextView)findViewById(R.id.option1);
    option2=(TextView)findViewById(R.id.option2);
    option3=(TextView)findViewById(R.id.option3);
    wrong1=(TextView)findViewById(R.id.wrong);
    correct1=(TextView)findViewById(R.id.correct);

	result=(TextView)findViewById(R.id.result);
	one=(Button) findViewById(R.id.one);
	two=(Button) findViewById(R.id.two);
	three=(Button) findViewById(R.id.three);


    content.add(new ImageQuestion(R.drawable.w28,"1"));
    content.add(new ImageQuestion(R.drawable.man9,"2"));
    content.add(new ImageQuestion(R.drawable.proh28,"3"));
    content.add(new ImageQuestion(R.drawable.proh12,"4"));
    content.add(new ImageQuestion(R.drawable.proh3,"5"));
    content.add(new ImageQuestion(R.drawable.w9,"6"));
    content.add(new ImageQuestion(R.drawable.proh13,"7"));
    content.add(new ImageQuestion(R.drawable.inf13,"8"));
    content.add(new ImageQuestion(R.drawable.w34,"9"));
    content.add(new ImageQuestion(R.drawable.proh10,"10"));
    content.add(new ImageQuestion(R.drawable.w10,"11"));
    content.add(new ImageQuestion(R.drawable.proh11,"12"));
    content.add(new ImageQuestion(R.drawable.w26,"13"));
    content.add(new ImageQuestion(R.drawable.inf12,"14"));
    content.add(new ImageQuestion(R.drawable.w16,"15"));
    content.add(new ImageQuestion(R.drawable.proh6,"16"));
    content.add(new ImageQuestion(R.drawable.proh25,"17"));
    content.add(new ImageQuestion(R.drawable.proh22,"18"));
    content.add(new ImageQuestion(R.drawable.w18,"19"));
    content.add(new ImageQuestion(R.drawable.proh24,"20"));
    content.add(new ImageQuestion(R.drawable.inf2,"21"));
    content.add(new ImageQuestion(R.drawable.proh8,"22"));
    content.add(new ImageQuestion(R.drawable.proh21,"23"));
    content.add(new ImageQuestion(R.drawable.w4,"24"));
    content.add(new ImageQuestion(R.drawable.proh18,"25"));
    content.add(new ImageQuestion(R.drawable.w24,"26"));
    content.add(new ImageQuestion(R.drawable.man10,"27"));
    content.add(new ImageQuestion(R.drawable.pri3,"28"));
    content.add(new ImageQuestion(R.drawable.w22,"29"));
    content.add(new ImageQuestion(R.drawable.man14,"30"));
    content.add(new ImageQuestion(R.drawable.w14,"31"));
    content.add(new ImageQuestion(R.drawable.proh9,"32"));
    content.add(new ImageQuestion(R.drawable.w25,"33"));
    content.add(new ImageQuestion(R.drawable.man13,"34"));
    content.add(new ImageQuestion(R.drawable.w32,"35"));
    content.add(new ImageQuestion(R.drawable.w20,"36"));
    content.add(new ImageQuestion(R.drawable.w30,"37"));
    content.add(new ImageQuestion(R.drawable.w5,"38"));
    content.add(new ImageQuestion(R.drawable.w7,"39"));
    content.add(new ImageQuestion(R.drawable.w31,"40"));
    content.add(new ImageQuestion(R.drawable.w11,"41"));

image.setVisibility(View.INVISIBLE);
	question.setVisibility(View.INVISIBLE);
	option1.setVisibility(View.INVISIBLE);
	option2.setVisibility(View.INVISIBLE);
	option3.setVisibility(View.INVISIBLE);
	wrong1.setVisibility(View.INVISIBLE);
	correct1.setVisibility(View.INVISIBLE);
	one.setVisibility(View.INVISIBLE);
	two.setVisibility(View.INVISIBLE);
	three.setVisibility(View.INVISIBLE);


confirm_question.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View v) {
		number=Integer.parseInt(no_question.getText().toString().trim());

		if(number>0){

		image.setVisibility(View.VISIBLE);
		question.setVisibility(View.VISIBLE);
		option1.setVisibility(View.VISIBLE);
		option2.setVisibility(View.VISIBLE);
		option3.setVisibility(View.VISIBLE);
		wrong1.setVisibility(View.VISIBLE);
		correct1.setVisibility(View.VISIBLE);
		one.setVisibility(View.VISIBLE);
		two.setVisibility(View.VISIBLE);
		three.setVisibility(View.VISIBLE);

		no_question.setVisibility(View.INVISIBLE);
			confirm_question.setVisibility(View.INVISIBLE);
		}
	}
});
    get_question();
    one.setOnClickListener(new View.OnClickListener() {
	    @Override
	    public void onClick(View v) {
	    	String response=option1.getText().toString().trim();
		    if(counter==number)
		    {  validation(response);
			    image.setVisibility(View.INVISIBLE);
			    question.setVisibility(View.INVISIBLE);
			    option1.setVisibility(View.INVISIBLE);
			    option2.setVisibility(View.INVISIBLE);
			    option3.setVisibility(View.INVISIBLE);
			    wrong1.setVisibility(View.INVISIBLE);
			    correct1.setVisibility(View.INVISIBLE);
			    one.setVisibility(View.INVISIBLE);
			    two.setVisibility(View.INVISIBLE);
			    three.setVisibility(View.INVISIBLE);
			    String w= String.valueOf(wrong);
			    String c= String.valueOf(correct);
			    result.setText("Correct : "+c+" Wrong : "+w);

		    }
		    else{
			    validation(response);
			    get_question();
		    }

	    }
    });



	two.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			String response=option2.getText().toString().trim();
			if(counter==number)
			{  validation(response);
				image.setVisibility(View.INVISIBLE);
				question.setVisibility(View.INVISIBLE);
				option1.setVisibility(View.INVISIBLE);
				option2.setVisibility(View.INVISIBLE);
				option3.setVisibility(View.INVISIBLE);
				wrong1.setVisibility(View.INVISIBLE);
				correct1.setVisibility(View.INVISIBLE);
				one.setVisibility(View.INVISIBLE);
				two.setVisibility(View.INVISIBLE);
				three.setVisibility(View.INVISIBLE);
				String w= String.valueOf(wrong);
				String c= String.valueOf(correct);
				result.setText("Correct : "+c+" Wrong : "+w);

			}
			else{
				validation(response);
				get_question();
			}
		}
	});




	three.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			String response=option3.getText().toString().trim();
			if(counter==number)
			{  validation(response);
				image.setVisibility(View.INVISIBLE);
				question.setVisibility(View.INVISIBLE);
				option1.setVisibility(View.INVISIBLE);
				option2.setVisibility(View.INVISIBLE);
				option3.setVisibility(View.INVISIBLE);
				wrong1.setVisibility(View.INVISIBLE);
				correct1.setVisibility(View.INVISIBLE);
				one.setVisibility(View.INVISIBLE);
				two.setVisibility(View.INVISIBLE);
				three.setVisibility(View.INVISIBLE);
				String w= String.valueOf(wrong);
				String c= String.valueOf(correct);
				result.setText("Correct : "+c+" Wrong : "+w);

			}
			else{
				validation(response);
				get_question();
			}
		}
	});
}

public void validation(String ans)
{
	if(ans.equals(answer))
	{
		correct++;
	}
	else
	{
		wrong++;
	}

    String w= String.valueOf(wrong);
	String c= String.valueOf(correct);
	wrong1.setText("Wrong : "+w);
	correct1.setText("Correct : "+c);
}


public  void get_question()
{
	counter++;

    final Random random = new Random();
    id = random.nextInt(41) - 1;
result.setText("");

    DatabaseReference reff;

    reff = FirebaseDatabase.getInstance().getReference().child("Question").child(content.get(id).getQuestion_id());

    reff.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String quest = dataSnapshot.child("Quest").getValue().toString().trim();
            String opt1 = dataSnapshot.child("opt1").getValue().toString().trim();
            String opt2 = dataSnapshot.child("opt2").getValue().toString().trim();
            String ans = dataSnapshot.child("ans").getValue().toString().trim();


            answer = ans;
            question.setText(quest);
            int position=random.nextInt(3);
            if (position== 0) {
                option1.setText(opt2);
                option2.setText(ans);
                option3.setText(opt1);


            }
            if (position== 1) {

                option1.setText(ans);
                option2.setText(opt1);
                option3.setText(opt2);

            }
            if (position== 2) {


                option1.setText(opt2);
                option2.setText(opt1);
                option3.setText(ans);

            }


	        image.setImageResource(content.get(id).getImage());
        }


        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            System.out.println("error");
	        result.setText("No internet connection");

        }
    });
}

}


