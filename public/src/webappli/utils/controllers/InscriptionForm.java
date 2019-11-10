package webappli.utils.controllers;

import org.mindrot.jbcrypt.BCrypt;
import webappli.models.Admins;
import webappli.utils.database.Database;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class InscriptionForm {
    private static final String champ_nom = "nom";
    private static final String champ_prenom = "prenom";
    private static final String champ_mail = "mail";
    private static final String champ_telephone = "telephone";
    private static final String champ_birthday = "birthday";
    private static final String champ_role = "role";
    private static final String champ_password = "password";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    private String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
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
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
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
            validationRole(role);
        } catch (Exception e) {
            setErreur(champ_role, e.getMessage());
        }
        try {
            validationBirthday(birthday);

        } catch (Exception e) {
            setErreur(champ_birthday, e.getMessage());
        }
        try {
            validationPassword(password);

        } catch (Exception e) {
            setErreur(champ_password, e.getMessage());
        }

        if (erreurs.isEmpty()) {
            admins.setNom(nom);
            admins.setPrenom(prenom);
            admins.setMail(mail);
            admins.setTelephone(telephone);
            admins.setBirthday(birthday);
            admins.setRole(role);
            admins.setPassword(hash);
            Database.insert(admins);
        }
        return admins;
    }

    private void validationNom(String nom) throws Exception {
        if (nom == null || nom.length() < 3) {
            throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
        }
    }

    private void validationPrenom(String prenom) throws Exception {
        if (prenom == null || prenom.length() < 3) {
            throw new Exception("Le Prénom d'utilisateur doit contenir au moins 3 caractères.");
        }
    }

    private void validationMail(String mail) throws Exception {
        Admins _adminCtrl = new Admins();
        List<String> adminMail = new ArrayList<>();
        ArrayList<String> fields = new ArrayList<>();
        fields.add("*");
        List<Admins> selMail = Database.select(_adminCtrl, fields);
        for (Admins admin : selMail) {
            adminMail.add(admin.getMail());
        }
        if (mail != null) {
            if (!mail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Merci de saisir une adresse mail valide.");
            } else if (adminMail.contains(mail)) {
                throw new Exception("Ce mail est déjà attribué à un compte Admin.");
            }
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }

    private void validationTelehone(String telephone) throws Exception {
        Admins _adminCtrl2 = new Admins();
        List<String> adminTel = new ArrayList<>();
        ArrayList<String> fields = new ArrayList<>();
        fields.add("*");
        List<Admins> selTel = Database.select(_adminCtrl2, fields);
        for (Admins admin : selTel) {
            adminTel.add(admin.getTelephone());
        }
        if (telephone == null || telephone.length() < 9) {
            throw new Exception("Le téléphone doit contenir au moins 10 numéros.");
        } else if (adminTel.contains(telephone)) {
            throw new Exception("Ce téléphone est déjà attribué à un Admin.");
        }
    }

    private void validationBirthday(String birthday) throws Exception {
        if (birthday.isEmpty()) {
            throw new Exception("Merci de saisir une date de naissance.");
        }
    }

    private void validationRole(String role) throws Exception {
        String admin = "admin";
        String supAdmin = "supAdmin";
        if (!role.equals(admin) && !role.equals(supAdmin)) {
            throw new Exception("La valeur ne correspond à aucun rôle");
        }
    }

    private void validationPassword(String password) throws Exception {
        if (password != null) {
            if (password.length() < 8) {
                throw new Exception("Les mots de passe doivent contenir au moins 8 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir votre mot de passe.");
        }
    }

    public void setErreur(String champ, String message) {
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

