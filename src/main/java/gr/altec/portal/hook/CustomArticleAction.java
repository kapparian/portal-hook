/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.altec.portal.hook;

import gr.altec.portal.hook.blcontrollers.DocumentUploadController;
import gr.altec.portal.hook.structures.InviteContentStructure;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.model.Image;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleImageLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import gr.altec.portal.hook.blcontrollers.ArticleImageUploadController;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Spiros Batzio
 */
public class CustomArticleAction extends Action {

    @Override
    public void run(HttpServletRequest hsr, HttpServletResponse hsr1) throws ActionException {

        System.out.println("Before addArticle into the new Thread");

        try {
            addArticle();
            //System.out.println("Ok we ve done with the article");
            Image myimg = new ArticleImageUploadController().uploadArticleImage();
            //System.err.println(myimg);
            //System.out.println(new ArticleImageUploadController().uploadArticleImage());
           // System.out.println("done with the doc too!!");
        } catch (PortalException ex) {
            Logger.getLogger(CustomArticleAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(CustomArticleAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomArticleAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(CustomArticleAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CustomArticleAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("after addArticle stuff");

//            }
//        };
//
//        one.start();
    }

    public void addDocs() {

    }

    public void addArticle() throws PortalException, SystemException, FileNotFoundException, MalformedURLException, URISyntaxException {

        //Hook Folder ID : 105071
        //Altec User ID : 20435
        //GroupID for Guest users : 20182
        //Structure Key for Invites : 105623
        //Template Key for Invites : 105625
        String[] titleMapLanguageIds = {"en_US"}, titleMapValues = {"Invite17"};
        String[] descriptionMapLanguageIds = {"en_US"}, descriptionMapValues = {"A new invite to test hook importer"};

        Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(titleMapLanguageIds, titleMapValues);
        Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(descriptionMapLanguageIds, descriptionMapValues);

        Image img = new ArticleImageUploadController().uploadArticleImage();
        System.out.println(img);
        
        String content = new InviteContentStructure().generateContentStructure();

        System.out.println(content);
        GregorianCalendar date = (GregorianCalendar) GregorianCalendar.getInstance(Locale.ENGLISH);

        ServiceContext st = new ServiceContext();
        st.setUserId(20435);
        st.setCompanyId(20155);
        st.setScopeGroupId(20182);
        st.setAddGroupPermissions(true);
        
        
        
        JournalArticle article = JournalArticleLocalServiceUtil.addArticle(20435, 20182, 105071, titleMap, descriptionMap, content, "105622", "105624", st);
        //System.out.println("just send dat to web content");
        
        //setting image to article
        JournalArticleImageLocalServiceUtil.addArticleImageId(img.getImageId(), 20155, article.getArticleId(), 1.0, "", "Image3004", "");
        DocumentUploadController dc = new DocumentUploadController();
        dc.uploadDocument(st);
        
        

    }

}
