/**
 * This class is ...
 * 
 * <P>
                                                       
 * <P>  
 *
 * @SINCE 1.0
 * @AUTHOR RCARON
 * @VERSION 1.0
 */
package com.blastvibrations.jpa.util;

import org.hibernate.spatial.dialect.postgis.PostgisDialect;

import java.sql.Types;

/**
 * Wrap default PostgisDialect with 'json' type.
 */
@SuppressWarnings("serial")
public class PTMJsonPostgisDialect extends PostgisDialect {

    public PTMJsonPostgisDialect() {
        super();
        this.registerColumnType(Types.VARCHAR, "json");
        this.registerColumnType(Types.VARCHAR, "jsonp");
    }
}
