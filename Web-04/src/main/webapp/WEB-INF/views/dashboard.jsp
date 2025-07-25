<%@ include file="header.jsp" %>

<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h4 class="mb-0">
                    <i class="fas fa-calendar-check"></i> 
                    Minhas Consultas - Dr(a). ${sessionScope.medico.nome}
                </h4>
            </div>
            <div class="card-body">
                <c:if test="${empty consultas}">
                    <div class="alert alert-info" role="alert">
                        <i class="fas fa-info-circle"></i> 
                        Você não possui consultas pendentes no momento.
                    </div>
                </c:if>
                
                <c:if test="${not empty consultas}">
                    <div class="table-responsive">
                        <table class="table table-striped table-hover">
                            <thead class="table-dark">
                                <tr>
                                    <th>Data/Hora</th>
                                    <th>Paciente</th>
                                    <th>Observações</th>
                                    <th>Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="consulta" items="${consultas}">
                                    <tr>
                                        <td>
                                            <fmt:formatDate value="${consulta.dataHora}" pattern="dd/MM/yyyy HH:mm"/>
                                        </td>
                                        <td>
                                            <strong>${consulta.paciente.nome}</strong><br>
                                            <small class="text-muted">CPF: ${consulta.paciente.cpf}</small>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${not empty consulta.observacoes}">
                                                    ${consulta.observacoes}
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="text-muted">Sem observações</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/consulta?id=${consulta.id}" 
                                               class="btn btn-primary btn-sm">
                                                <i class="fas fa-eye"></i> Visualizar
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>

<div class="row mt-4">
    <div class="col-12 text-center">
        <a href="${pageContext.request.contextPath}/cadastro-consulta" class="btn btn-success">
            <i class="fas fa-calendar-plus"></i> Nova Consulta
        </a>
    </div>
</div>

<%@ include file="footer.jsp" %>
