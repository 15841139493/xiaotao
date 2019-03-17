package com.xiaotao.portal.pojo;

import com.xiaotao.pojo.TbItem;

public class PortIbItem extends TbItem {
	
	public String[] getImages(){
		if(this.getImage() != null && !this.getImage().equals("")){
			String[] images = this.getImage().split(",");
			return images;
		}
		return null;
	}

}
