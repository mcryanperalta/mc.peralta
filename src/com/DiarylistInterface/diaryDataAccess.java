package com.DiarylistInterface;

import java.util.ArrayList;
import diarylist.diary;

public interface diaryDataAccess {
	
		public String insertDiary(diary diary1, byte[] urlHolder);
		public ArrayList<diary> selectAllDiary();
		public String deleteDiary(String name1);
		public ArrayList<diary> selectADiary(String name2);
	
}
