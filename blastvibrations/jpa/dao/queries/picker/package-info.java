//@formatter:off
@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = PickerQueries.PICKER_FIND_FOR_CLIENT, query = "SELECT p FROM ExPicker p where p.clientId = :clientId and p.pickerType = :pickerTypeName and p.deleted = false  order by p.description"),
	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = PickerQueries.PICKER_FIND_FOR_CLIENT_LIST, query = "SELECT p FROM ExPicker p where p.clientId IN (:clientIdList)  and p.deleted = false "),
	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = PickerQueries.PICKER_FIND_ALL_FOR_CLIENT_IS_NULL, query = "SELECT p FROM ExPicker p where p.clientId is null and p.deleted = false "),
	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = PickerQueries.PICKER_FIND_FOR_CLIENT_IS_NULL, query = "SELECT p FROM ExPicker p where p.clientId is null and p.pickerType = :pickerTypeName and p.deleted = false  order by p.description"),
	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = PickerQueries.PICKER_FIND_FOR_EXISTING_CLIENT_AND_NULL, query = "SELECT p FROM ExPicker p where (p.clientId = :clientId or p.clientId is null) and p.pickerType = :pickerTypeName  and p.deleted = false  order by p.description"),
	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = PickerQueries.PICKER_FIND_FOR_EXISTING_PICKER_AND_CLIENT_AND_NULL, query = "SELECT p FROM ExPicker p where p.pickerId = :pickerId and (p.clientId = :clientId or p.clientId is null) and p.pickerType = :pickerTypeName and p.deleted = false order by p.description")

})
package com.blastvibrations.jpa.dao.queries.picker;