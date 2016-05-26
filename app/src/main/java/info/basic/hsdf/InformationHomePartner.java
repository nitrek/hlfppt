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
        informationHome.add(new InformationHomePartner("Government Of India","http://www.hlfppt.org/images/6.jpg",R.drawable.partner_6));
        informationHome.add(new InformationHomePartner("National Rural Health Misssion", "http://mohfw.nic.in/NRHM.htm",R.drawable.partner_2));
        informationHome.add(new InformationHomePartner("NACO","http://www.nacoonline.org/NACO/",R.drawable.partner_11));
        informationHome.add(new InformationHomePartner("hlllifecare","http://www.lifecarehll.com/index_hlllifecare.html",R.drawable.partner_20));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_1));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_3));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_5));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_7));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_9));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_12));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_13));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_14));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_16));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_17));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_19));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_25));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_33));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_akzo_novel_logo));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_dlf_foundation_logo));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_essar_oil_logo));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_essar_steel_logo));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_fisher_department_kerla));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_idfc_logo));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_dlf_foundation_logo));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_dlf_foundation_logo));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_dlf_foundation_logo));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_dlf_foundation_logo));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_dlf_foundation_logo));
        informationHome.add(new InformationHomePartner("Sifpsa","http://www.sifpsa.org/",R.drawable.partner_dlf_foundation_logo));
        return  informationHome;
    }
}
