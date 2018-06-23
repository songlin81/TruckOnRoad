package com.chubbymobile.wwh.truckonroad.presenter;

import com.chubbymobile.wwh.truckonroad.bean.Parts;
import com.chubbymobile.wwh.truckonroad.view.IShowPartsView;

import java.util.ArrayList;

public class PartsInfoPresenter {

    private IShowPartsView iShowPartsView;

    public PartsInfoPresenter(IShowPartsView iShowPartsView) {
        this.iShowPartsView = iShowPartsView;
        iShowPartsView.toActivity(GetSearchResults());
    }

    private ArrayList<Parts> GetSearchResults(){
        ArrayList<Parts> results = new ArrayList<Parts>();

        Parts item_details = new Parts();
        item_details.setName("FM");
        item_details.setItemDescription("High Load");
        item_details.setPrice("SEK 310.00");
        item_details.setImageNumber(1);
        item_details.setSelected(false);
        results.add(item_details);

        item_details = new Parts();
        item_details.setName("FM");
        item_details.setItemDescription("Construction");
        item_details.setPrice("SEK 350.00");
        item_details.setImageNumber(2);
        item_details.setSelected(false);
        results.add(item_details);

        item_details = new Parts();
        item_details.setName("SK");
        item_details.setItemDescription("Delivery");
        item_details.setPrice("SEK 250.00");
        item_details.setImageNumber(3);
        item_details.setSelected(false);
        results.add(item_details);

        item_details = new Parts();
        item_details.setName("LH");
        item_details.setItemDescription("Tumble");
        item_details.setPrice("SEK 350.00");
        item_details.setImageNumber(4);
        item_details.setSelected(false);
        results.add(item_details);

        item_details = new Parts();
        item_details.setName("LW");
        item_details.setItemDescription("Freezer");
        item_details.setPrice("SEK 310.00");
        item_details.setImageNumber(5);
        item_details.setSelected(false);
        results.add(item_details);

        item_details = new Parts();
        item_details.setName("TH");
        item_details.setItemDescription("On Site");
        item_details.setPrice("SEK 250.00");
        item_details.setImageNumber(6);
        item_details.setSelected(false);
        results.add(item_details);

        return results;
    }
}
