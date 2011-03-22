<?xml version="1.0" encoding="UTF-8" ?>
<!--
    Document   : OrderProcessin.xslt
    Author     : Vincent
    Description: Creating a stylesheet file to apply it to XML data and 
                 convert it into HTML which is then presented to the user. 
    Copyright © 2007 Aptech Software Limited. All rights reserved.
-->
<xsl:stylesheet version="1.0" 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <TABLE BORDER="1">
            <TR bgcolor="0x0000ff">
            
                <!-- Creates a column for customers -->
                <TD>                    
                    <font color="#FFFFFF">
                        
                    </font>
                </TD>
                
                <!-- Creates a column for items -->
                <TD>                    
                    <font color="#FFFFFF">
                        Item
                    </font>
                </TD>
                
                <!-- Creates a column for quantities -->
                <TD>
                    <font color="#FFFFFF">
                        Quantity
                    </font>
                </TD>
                
                <!-- Creates a column for prices -->
                <TD>                    
                    <font color="#FFFFFF">
                        Price
                    </font>
                </TD>
            </TR>
            
            <!-- Processes only node 'customers' -->
            <xsl:apply-templates select ="customers"/>
        </TABLE>
    </xsl:template>
    
    <!-- Matches element 'customer' -->
    <xsl:template match="customers">
        
        <!-- Applies template to the node 'customer'-->
        <xsl:apply-templates select ="customer">
        
            <!-- Sort the prices in ascending order -->
            <xsl:sort select="price" order="ascending" data-type="number"/>
        </xsl:apply-templates>
    </xsl:template> 
    
    <!-- Matches node 'customer' -->
    <xsl:template match="customer">
        <TR>
            <TD>
                <!-- Display the name of the customers --> 
                <font color="#0000ff" size="+1">         
                    <xsl:value-of select ="name"/>
                </font>
            </TD>
        
            <!-- Display the name of the items --> 
            <TD bgcolor="#00FFFF">
                <xsl:value-of select="item"/>
            </TD>
            <!-- Display the quantites --> 
            <TD>
                <p align="right">
                    <xsl:value-of select="quantity"/>
                </p>
            </TD>
        
            <!-- Display the prices --> 
            <TD bgcolor="#00FFFF">
                <p align="right">
                    <xsl:value-of select="price"/>      
                </p>
            </TD>
        </TR>
    </xsl:template> 
</xsl:stylesheet>