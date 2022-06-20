function AdminTable(props){
    let columns = props.columns

   /* return (
        <div class="admin-table">
            <table>
                <thead>
                <th>${number}</th>
                <th>${promo_code}</th>
                <th colspan="2">${action}</th>
                </thead>
                <tbody>
                    <c:if test="${promo_codes_list != null && !promo_codes_list.isEmpty()}">
                        <c:forEach var="promoCode" items="${promo_codes_list}" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td>${promoCode.getName()}</td>
                                <td>
                                    <a href="promo-codes.do?command=show_promo_code_edit&promo_code_id=${promoCode.getPromoCodeId()}"
                                        class="admin-edit">${edit}</a>
                                </td>
                                <td>
                                    <input type="hidden" name="command" value="delete_promo_code">
                                    <input type="hidden" name="promo_code_id" value="${promoCode.getPromoCodeId()}">
                                    <a href="#" class="admin-delete">${delete}</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
    )*/
}

export default AdminTable;