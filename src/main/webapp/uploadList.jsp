<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<html>
    <body>
                        檔案已經儲存到:
        <a href="upload/<struts:property value="pictureFileName" />"
            target=_blank><struts:property value="pictureFileName" />
            </a> </br> </br>
            &lt;&lt;<a href="upload.action">繼續上傳</a>
    </body>
</html>