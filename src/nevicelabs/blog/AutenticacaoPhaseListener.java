package nevicelabs.blog;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import java.util.regex.Pattern;

public class AutenticacaoPhaseListener implements PhaseListener {

    private static final String RESTRICTION_PATTERN = "^/restrito/.*";

    /**
     * Neste método definimos o que acontece após do carregamento da fase.
     * @param phaseEvent
     */
    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        FacesContext context = phaseEvent.getFacesContext();
        String viewId = context.getViewRoot().getViewId();
        boolean urlProtegida = Pattern.matches(RESTRICTION_PATTERN, viewId);
        Object usuario = context.getExternalContext().getSessionMap().get("usuarioLogado");

        if(urlProtegida && usuario == null) {
            NavigationHandler navigator = context.getApplication().getNavigationHandler();
            navigator.handleNavigation(context, null, "login");
        }
    }

    /**
     * Neste método definimos o que acontece antes do carregamento da fase.
     * Como estamos monitorando a Restore View, não há pré-fase. Logo,
     * deixamos este método em branco.
     * @param phaseEvent
     */
    @Override
    public void beforePhase(PhaseEvent phaseEvent) { }

    /**
     * Neste método definimos qual fase do JSF queremos monitorar.
     * @return O id da fase monitorada
     */
    @Override
    public PhaseId getPhaseId() {
        // RestoreView é a primeira fase do JSF
        return PhaseId.RESTORE_VIEW;
    }
}