<%@ include file="header.jsp" %>

<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-header bg-info text-white">
                <h4 class="mb-0">
                    <i class="fas fa-stethoscope"></i> Detalhes da Consulta
                </h4>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-6">
                        <h5><i class="fas fa-user-md"></i> Médico</h5>
                        <p><strong>Nome:</strong> Dr(a). ${consulta.medico.nome}</p>
                        <p><strong>CRM:</strong> ${consulta.medico.crm}</p>
                        <p><strong>Especialidade:</strong> ${consulta.medico.especialidade}</p>
                    </div>
                    <div class="col-md-6">
                        <h5><i class="fas fa-user"></i> Paciente</h5>
                        <p><strong>Nome:</strong> ${consulta.paciente.nome}</p>
                        <p><strong>CPF:</strong> ${consulta.paciente.cpf}</p>
                        <p><strong>Telefone:</strong> ${consulta.paciente.telefone}</p>
                        <p><strong>Email:</strong> ${consulta.paciente.email}</p>
                    </div>
                </div>
                
                <hr>
                
                <div class="row">
                    <div class="col-md-12">
                        <h5><i class="fas fa-calendar"></i> Informações da Consulta</h5>
                        <p><strong>Data/Hora:</strong> <fmt:formatDate value="${consulta.dataHora}" pattern="dd/MM/yyyy 'às' HH:mm"/></p>
                        <c:if test="${not empty consulta.observacoes}">
                            <p><strong>Observações:</strong> ${consulta.observacoes}</p>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="row mt-4">
    <div class="col-12">
        <div class="card">
            <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                <h5 class="mb-0"><i class="fas fa-file-medical"></i> Prontuário</h5>
                <c:if test="${empty prontuario}">
                    <button class="btn btn-light btn-sm" data-bs-toggle="modal" data-bs-target="#modalProntuario">
                        <i class="fas fa-plus"></i> Adicionar
                    </button>
                </c:if>
            </div>
            <div class="card-body">
                <c:choose>
                    <c:when test="${not empty prontuario}">
                        <div class="row">
                            <div class="col-md-6">
                                <p><strong>Sintomas:</strong></p>
                                <p>${prontuario.sintomas}</p>
                            </div>
                            <div class="col-md-6">
                                <p><strong>Diagnóstico:</strong></p>
                                <p>${prontuario.diagnostico}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <p><strong>Tratamento:</strong></p>
                                <p>${prontuario.tratamento}</p>
                            </div>
                            <div class="col-md-6">
                                <p><strong>Observações:</strong></p>
                                <p>${prontuario.observacoes}</p>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <p class="text-muted">Prontuário ainda não foi cadastrado.</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>

<div class="row mt-4">
    <div class="col-12">
        <div class="card">
            <div class="card-header bg-success text-white d-flex justify-content-between align-items-center">
                <h5 class="mb-0"><i class="fas fa-prescription"></i> Receituário</h5>
                <c:if test="${empty receituario}">
                    <button class="btn btn-light btn-sm" data-bs-toggle="modal" data-bs-target="#modalReceituario">
                        <i class="fas fa-plus"></i> Adicionar
                    </button>
                </c:if>
            </div>
            <div class="card-body">
                <c:choose>
                    <c:when test="${not empty receituario}">
                        <div class="row">
                            <div class="col-md-4">
                                <p><strong>Medicamentos:</strong></p>
                                <p>${receituario.medicamentos}</p>
                            </div>
                            <div class="col-md-4">
                                <p><strong>Dosagem:</strong></p>
                                <p>${receituario.dosagem}</p>
                            </div>
                            <div class="col-md-4">
                                <p><strong>Instruções:</strong></p>
                                <p>${receituario.instrucoes}</p>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <p class="text-muted">Receituário ainda não foi cadastrado.</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>

<div class="row mt-4">
    <div class="col-12">
        <div class="card">
            <div class="card-header bg-warning text-dark d-flex justify-content-between align-items-center">
                <h5 class="mb-0"><i class="fas fa-microscope"></i> Exame</h5>
                <c:if test="${empty exame}">
                    <button class="btn btn-dark btn-sm" data-bs-toggle="modal" data-bs-target="#modalExame">
                        <i class="fas fa-plus"></i> Adicionar
                    </button>
                </c:if>
            </div>
            <div class="card-body">
                <c:choose>
                    <c:when test="${not empty exame}">
                        <div class="row">
                            <div class="col-md-3">
                                <p><strong>Tipo:</strong></p>
                                <p>${exame.tipoExame}</p>
                            </div>
                            <div class="col-md-3">
                                <p><strong>Data:</strong></p>
                                <p><fmt:formatDate value="${exame.dataExame}" pattern="dd/MM/yyyy HH:mm"/></p>
                            </div>
                            <div class="col-md-6">
                                <p><strong>Descrição:</strong></p>
                                <p>${exame.descricao}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <p><strong>Resultado:</strong></p>
                                <p>${exame.resultado}</p>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <p class="text-muted">Exame ainda não foi cadastrado.</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>

<div class="row mt-4">
    <div class="col-12 text-center">
        <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-secondary">
            <i class="fas fa-arrow-left"></i> Voltar ao Dashboard
        </a>
    </div>
</div>

<div class="modal fade" id="modalProntuario" tabindex="-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Cadastrar Prontuário</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <form action="${pageContext.request.contextPath}/cadastro-prontuario" method="post">
                <div class="modal-body">
                    <input type="hidden" name="consultaId" value="${consulta.id}">
                    <div class="mb-3">
                        <label for="sintomas" class="form-label">Sintomas:</label>
                        <textarea class="form-control" id="sintomas" name="sintomas" rows="3" required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="diagnostico" class="form-label">Diagnóstico:</label>
                        <textarea class="form-control" id="diagnostico" name="diagnostico" rows="3" required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="tratamento" class="form-label">Tratamento:</label>
                        <textarea class="form-control" id="tratamento" name="tratamento" rows="3" required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="observacoesProntuario" class="form-label">Observações:</label>
                        <textarea class="form-control" id="observacoesProntuario" name="observacoes" rows="2"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Salvar Prontuário</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="modalReceituario" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Cadastrar Receituário</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <form action="${pageContext.request.contextPath}/cadastro-receituario" method="post">
                <div class="modal-body">
                    <input type="hidden" name="consultaId" value="${consulta.id}">
                    <div class="mb-3">
                        <label for="medicamentos" class="form-label">Medicamentos:</label>
                        <textarea class="form-control" id="medicamentos" name="medicamentos" rows="3" required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="dosagem" class="form-label">Dosagem:</label>
                        <textarea class="form-control" id="dosagem" name="dosagem" rows="2" required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="instrucoesReceita" class="form-label">Instruções:</label>
                        <textarea class="form-control" id="instrucoesReceita" name="instrucoes" rows="3" required></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-success">Salvar Receituário</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="modalExame" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Cadastrar Exame</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <form action="${pageContext.request.contextPath}/cadastro-exame" method="post">
                <div class="modal-body">
                    <input type="hidden" name="consultaId" value="${consulta.id}">
                    <div class="mb-3">
                        <label for="tipoExame" class="form-label">Tipo do Exame:</label>
                        <input type="text" class="form-control" id="tipoExame" name="tipoExame" required>
                    </div>
                    <div class="mb-3">
                        <label for="dataExame" class="form-label">Data do Exame:</label>
                        <input type="datetime-local" class="form-control" id="dataExame" name="dataExame" required>
                    </div>
                    <div class="mb-3">
                        <label for="descricaoExame" class="form-label">Descrição:</label>
                        <textarea class="form-control" id="descricaoExame" name="descricao" rows="3" required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="resultado" class="form-label">Resultado:</label>
                        <textarea class="form-control" id="resultado" name="resultado" rows="3"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-warning">Salvar Exame</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
