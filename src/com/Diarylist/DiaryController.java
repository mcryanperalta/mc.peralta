package com.Diarylist;
import com.DiarylistInterface.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.DiarylistInterface.diaryDataAccess;
import diarylist.diary;
import java.io.FileNotFoundException;
import java.util.ArrayList;



@Controller
public class DiaryController {

@RequestMapping(value ="/diarylist", method = RequestMethod.GET)
protected ModelAndView GetAdmission() throws Exception {
	
	ApplicationContextProvider appContext = new ApplicationContextProvider();
    diaryDataAccess dataAccess = (diaryDataAccess) appContext.getApplicationContext().getBean("diaryDataAccess",DiaryImpl.class);
    ArrayList<diary> result = new ArrayList<>();
    result = dataAccess.selectAllDiary();
	
	ModelAndView modelandview = new ModelAndView("Admission");
	modelandview.addObject("myData", result);
	return modelandview;
	
}
@ModelAttribute
public void commonObject(Model model1)
{
	model1.addAttribute("headMessage","My Diary");
}

@RequestMapping(value ="/new", method = RequestMethod.POST)
protected ModelAndView hi(@ModelAttribute("student1") Student student1) throws Exception {
	
	 
	
	ModelAndView modelandview = new ModelAndView("HelloPage");
	modelandview.addObject("headMessage2", "You are now registered!! Congratulations!" );
	return modelandview;
}

@RequestMapping(value= "/submitdata",method = RequestMethod.POST)
	protected ModelAndView insertRecord(@RequestParam(value="title") String name,@RequestParam(value="date") String date1, @RequestParam(value="text") String text, @RequestParam("urlHolder") String urlHolder) throws FileNotFoundException
	{
	 byte[] img = urlHolder.getBytes();
      //  byte[] decodedString = Base64.getDecoder().decode(new String(name).getBytes("UTF-8"));
	 
		ApplicationContextProvider appContext = new ApplicationContextProvider();
        diaryDataAccess dataAccess = (diaryDataAccess) appContext.getApplicationContext().getBean("diaryDataAccess",DiaryImpl.class);
        diary diary1 = new diary();
        diary1.setDate(date1);
        diary1.setName(name);
        diary1.setText(text);
        String result = dataAccess.insertDiary(diary1,img);	
      if(result != "ok")
      {
    	  ModelAndView modelandview = new ModelAndView("result");
      	modelandview.addObject("result", result);
      	return modelandview;
      }
        ArrayList<diary> result2 = new ArrayList<>();
        result2 = dataAccess.selectAllDiary();
    	ModelAndView modelandview = new ModelAndView("Admission");
    	modelandview.addObject("myData", result2);
    	return modelandview;
	}

@RequestMapping(value ="/edit", method = RequestMethod.POST)
protected ModelAndView test(@RequestParam("holder") String holder) throws Exception {
	
	ModelAndView modelandview = new ModelAndView("HelloPage");
	ApplicationContextProvider appContext = new ApplicationContextProvider();
    diaryDataAccess dataAccess = (diaryDataAccess) appContext.getApplicationContext().getBean("diaryDataAccess",DiaryImpl.class);
    ArrayList<diary> result = new ArrayList<>();
    result = dataAccess.selectADiary(holder);
	modelandview.addObject("myData2", result );
	return modelandview;
}

@RequestMapping(value= "/delete",method = RequestMethod.POST)
protected ModelAndView deleterecord(@RequestParam(value="title") String name,@RequestParam(value="date") String date1, @RequestParam(value="text") String text, @RequestParam("urlHolder") String urlHolder) throws FileNotFoundException
{
	ApplicationContextProvider appContext = new ApplicationContextProvider();
    diaryDataAccess dataAccess = (diaryDataAccess) appContext.getApplicationContext().getBean("diaryDataAccess",DiaryImpl.class);
	String res = dataAccess.deleteDiary(name);
	if(res != "ok")
	{
		ModelAndView modelandview = new ModelAndView("result");
	 	modelandview.addObject("result", res);
	 	return modelandview;
	}
	ArrayList<diary> result2 = new ArrayList<>();
    result2 = dataAccess.selectAllDiary();
 	ModelAndView modelandview = new ModelAndView("Admission");
 	modelandview.addObject("myData", result2);
 	return modelandview;
}

	
}






