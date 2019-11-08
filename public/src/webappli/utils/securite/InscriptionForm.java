package webappli.utils.securite;

import webappli.models.Admins;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public final class InscriptionForm {
    private static final String champ_nom = "nom";
    private static final String champ_prenom = "prenom";
    private static final String champ_mail = "mail";
    private static final String champ_telephone = "telephone";
    private static final String champ_birthday = "birthday";
    private static final String champ_role = "role";
    private static final String champ_password = "password";
    private static final String champ_confirmation = "confirmation";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    private String getResultat() {
        return resultat;
    }

    private Map<String, String> getErreurs() {
        return erreurs;
    }

    public Admins ajoutAdmin(HttpServletRequest request) {

        String nom = getValeurChamp(request, champ_nom);
        String prenom = getValeurChamp(request, champ_prenom);
        String mail = getValeurChamp(request, champ_mail);
        String telephone = getValeurChamp(request, champ_telephone);
        String birthday = getValeurChamp(request, champ_birthday);
        String role = getValeurChamp(request, champ_role);
        String password = getValeurChamp(request, champ_password);
        String confirmation = getValeurChamp(request, champ_confirmation);
        Admins admins = new Admins();
        try {
            validationNom(nom);

        } catch (Exception e) {
            setErreur(champ_nom, e.getMessage());
        }
        try {
            validationPrenom(prenom);
        } catch (Exception e) {
            setErreur(champ_prenom, e.getMessage());
        }
        try {
            validationMail(mail);
        } catch (Exception e) {
            setErreur(champ_mail, e.getMessage());
        }
        try {
            validationTelehone(telephone);
        } catch (Exception e) {
            setErreur(champ_telephone, e.getMessage());
        }
        try {
            validationBirthday(birthday);

        } catch (Exception e) {
            setErreur(champ_birthday, e.getMessage());
        }
        try {
            validationPassword(password, confirmation);
        } catch (Exception e) {
            setErreur(champ_password, e.getMessage());
            setErreur(champ_confirmation, null);
        }
        return admins;
    }

    private void validationNom(String nom) throws Exception {
        if (nom != null && nom.length() < 3) {
            throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
        }
    }

    private void validationPrenom(String prenom) throws Exception {
        if (prenom != null && prenom.length() < 3) {
            throw new Exception("Le Prénom d'utilisateur doit contenir au moins 3 caractères.");
        }
    }

    private void validationMail(String mail) throws Exception {
        if (mail != null) {
            if (!mail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Merci de saisir une adresse mail valide.");
            }
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }

    private void validationTelehone(String telephone) throws Exception {
        if (telephone != null && telephone.length() < 10) {
            throw new Exception("Le téléphone doit contenir au moins 10 numéros.");
        }
    }

    private void validationBirthday(String birthday) throws Exception {
        if (birthday.isEmpty()) {
            throw new Exception("Merci de saisir une date de naissance.");
        }
    }

    private void validationPassword(String password, String confirmation) throws Exception {
        if (password != null && confirmation != null) {
            if (!password.equals(confirmation)) {
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (password.length() < 8) {
                throw new Exception("Les mots de passe doivent contenir au moins 8 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
        }
    }

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}