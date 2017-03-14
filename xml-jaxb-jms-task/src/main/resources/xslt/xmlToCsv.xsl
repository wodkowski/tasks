<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:output method="text" omit-xml-declaration="yes" indent="no" />
	<xsl:template match="/">
		<xsl:text>AUTHOR,TITLE,PUBLISHED</xsl:text>
		<xsl:text>&#xa;</xsl:text>
		<xsl:for-each select="//book">
			<xsl:variable name="aId" select="@author-id" />
			<xsl:value-of
				select="concat(//author[@id=$aId]/name, ' ', //author[@id=$aId]/surname)" />
			<xsl:value-of select="concat(',' , title, ',' , published, '')" />
			<xsl:text>&#xa;</xsl:text>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>