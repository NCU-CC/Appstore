<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>

<struts:actionerror/>
<struts:form action="upload" enctype="multipart/form-data" method="post" validate="true">
<struts:label value="上傳檔案"></struts:label>
<struts:file name="picture" label="檔案一"></struts:file>
<struts:submit value="開始上傳" method="upload"></struts:submit>
</struts:form>