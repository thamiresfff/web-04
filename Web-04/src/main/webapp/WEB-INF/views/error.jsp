<%@ include file="header.jsp" %>

<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="card">
            <div class="card-header bg-danger text-white">
                <h4 class="mb-0"><i class="fas fa-exclamation-triangle"></i> Erro</h4>
            </div>
            <div class="card-body text-center">
                <h5>Oops! Algo deu errado.</h5>
                <p class="text-muted">Ocorreu um erro inesperado. Por favor, tente novamente.</p>
                <a href="${pageContext.request.contextPath}/login" class="btn btn-primary">
                    <i class="fas fa-home"></i> Voltar ao Início
                </a>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
