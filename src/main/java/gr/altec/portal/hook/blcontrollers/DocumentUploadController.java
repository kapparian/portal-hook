/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.altec.portal.hook.blcontrollers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 *
 * @author bats-pc
 */
public class DocumentUploadController {

    public void uploadDocument(ServiceContext st) throws PortalException, SystemException, FileNotFoundException, MalformedURLException, URISyntaxException {

        //ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        //repoID for guest is 20182
        //folderId 0 in order to upload into root folder
        //ClassLoader classLoader = getClass().getClassLoader();
        ClassLoader classLoader = getClass().getClassLoader();
        File f = new File(classLoader.getResource("aristos11.png").getFile());

        System.out.println(f.getAbsolutePath());
        FileInputStream is = new FileInputStream(f);
        ThemeDisplay display = new ThemeDisplay();
        st.setScopeGroupId(20182);
        //String myUrl = display.getPortalURL()+display.getPathContext()+"/documents/"+display.getScopeGroupId()+File.separator+"0"+File.separator+"aristos11.png";
        DLAppServiceUtil.addFileEntry(20182, 0, "aristos11.png", null, null, null, null, is, 0, st);

        System.out.println("lalalala");
        FileEntry entry = DLAppServiceUtil.getFileEntry(20182, 0, "aristos11.png");
        System.out.println(entry.getCompanyId());
        System.out.println(entry.getFolder());
        entry.getTitle();
        System.out.println(((DLFileEntry) entry.getModel()).getName());
        System.out.println(entry.getVersion());
        //System.out.println(DLAppServiceUtil.getFileEntry(20182, 0, "aristos11.png"));

        //DLAppServiceUtil.getFileEntry(20182, 0, "aristos.png");
    }
}
