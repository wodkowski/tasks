<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://example.net/books/1.0"
	xmlns:a="http://example.net/author/1.0">
	<xsl:output method="xml" indent="yes" />

	<xsl:template match="/">
		<books>
			<xsl:for-each select="//book">
				<xsl:variable name="aId" select="@author-id" />
				<book>
					<a:author>
						<a:name>
							<xsl:value-of select="//author[@id=$aId]/name" />
						</a:name>
						<a:surname>
							<xsl:value-of select="//author[@id=$aId]/surname" />
						</a:surname>
					</a:author>
					<title>
						<xsl:value-of select="title" />
					</title>
				</book>
			</xsl:for-each>
		</books>
	</xsl:template>
</xsl:stylesheet>