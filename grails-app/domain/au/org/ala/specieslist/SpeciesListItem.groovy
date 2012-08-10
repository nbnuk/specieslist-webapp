/*
 * Copyright (C) 2012 Atlas of Living Australia
 * All Rights Reserved.
 *
 * The contents of this file are subject to the Mozilla Public
 * License Version 1.1 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 */

package au.org.ala.specieslist

class SpeciesListItem {

    String rawScientificName
    String dataResourceUid
    String guid
    Boolean isPublished //stores whether or not the species list for this item has been published to the BIE
    Date dateCreated
    Date lastUpdated

    static hasMany = [kvpValues: SpeciesListKVP]
    static belongsTo = [list:SpeciesList]

    static constraints = {
        //guid unique:  'name' //AK for the table
        isPublished(nullable:true)
        guid(nullable:true)
        //kvpValues(nullable: true)
    }

    static mapping ={
        dataResourceUid index: 'idx_data_resource_uid'
        guid index: 'idx_guid'
        kvpValues lazy: false
    }

}
