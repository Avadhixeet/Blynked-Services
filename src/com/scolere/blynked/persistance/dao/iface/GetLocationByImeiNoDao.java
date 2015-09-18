package com.scolere.blynked.persistance.dao.iface;

import java.util.ArrayList;

import com.scolere.blynked.web.VO.ImeiLocationResponseVO;


public interface GetLocationByImeiNoDao {

	ArrayList<ImeiLocationResponseVO> getNumbers(String numStr);

}
