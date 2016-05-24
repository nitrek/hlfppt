package info.basic.hsdf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nitesh on 8/5/16.
 */
public class InformationHomePartner {
    String heading;
    String imageURl;
    int imageId;
    InformationHomePartner(String heading, String imageURl, int imageId) {
        this.heading = heading;
        this.imageURl = imageURl;
        this.imageId = imageId;
    }

    public static List<InformationHomePartner> initializeData(){
        List<InformationHomePartner> informationHome;
        informationHome = new ArrayList<>();
        informationHome.add(new InformationHomePartner("pMaternal and Child health","http://www.hlfppt.org/images/03.jpg",R.drawable.maternal_child_health));
        informationHome.add(new InformationHomePartner("pAdolescent Health", "http://www.hlfppt.org/images/04.jpg",R.drawable.adolescent_health));
        informationHome.add(new InformationHomePartner("pFamily Planning","http://www.hlfppt.org/images/family_planning.jpg",R.drawable.family_planning));
        informationHome.add(new InformationHomePartner("pHIV/AIDS","http://www.hlfppt.org/images/02.jpg",R.drawable.hiv_aids));
        informationHome.add(new InformationHomePartner("pInformationHome","http://www.hlfppt.org/images/05.jpg",R.drawable.wellness));
        return  informationHome;
    }
}
