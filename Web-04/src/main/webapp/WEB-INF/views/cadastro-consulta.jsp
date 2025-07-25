<%@ include file="header.jsp" %>

<div class="row">
    <div class="col-md-8 offset-md-2">
        <div class="card">
            <div class="card-header bg-success text-white">
                <h4 class="mb-0">
                    <i class="fas fa-calendar-plus"></i> Cadastro de Consulta
                </h4>
            </div>
            <div class="card-body">
                <form method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="medicoId" class="form-label">Médico:</label>
                                <select class="form-select" id="medicoId" name="medicoId" required>
                                    <option value="">Selecione um médico</option>
                                    <c:forEach var="medico" items="${medicos}">
                                        <option value="${medico.id}">
                                            Dr(a). ${medico.nome} - ${medico.especialidade}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="pacienteId" class="form-label">Paciente:</label>
                                <select class="form-select" id="pacienteId" name="pacienteId" required>
                                    <option value="">Selecione um paciente</option>
                                    <c:forEach var="paciente" items="${pacientes}">
                                        <option value="${paciente.id}">
                                            ${paciente.nome} - CPF: ${paciente.cpf}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    
                    <div class="mb-3">
                        <label for="dataHora" class="form-label">Data e Hora:</label>
                        <input type="datetime-local" class="form-control" id="dataHora" name="dataHora" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="observacoes" class="form-label">Observações:</label>
                        <textarea class="form-control" id="observacoes" name="observacoes" rows="3" 
                                  placeholder="Observações sobre a consulta (opcional)"></textarea>
                    </div>
                    
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                        <a href="${pageContext.request.contextPath}/login" class="btn btn-secondary me-md-2">
                            <i class="fas fa-arrow-left"></i> Voltar
                        </a>
                        <button type="submit" class="btn btn-success">
                            <i class="fas fa-save"></i> Cadastrar Consulta
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    document.getElementById('dataHora').min = new Date().toISOString().slice(0, 16);
</script>

<%@ include file="footer.jsp" %>
