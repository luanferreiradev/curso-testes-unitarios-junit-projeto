package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.armazenamento.ArmazenamentoEditor;
import com.algaworks.junit.blog.exception.RegraNegocioException;
import com.algaworks.junit.blog.modelo.Editor;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CadastroEditorTest {

    static CadastroEditor cadastroEditor;
    Editor editor;
    ArmazenamentoEditorFixoEmMemoria armazenamentoEditor;

    @BeforeEach
    void beforeEach() {
        armazenamentoEditor = new ArmazenamentoEditorFixoEmMemoria();
        cadastroEditor = new CadastroEditor(armazenamentoEditor, new GerenciadorEnvioEmail() {
            @Override
            void enviarEmail(Mensagem mensagem) {
                System.out.println("Enviando mensagem para: " + mensagem.getDestinatario());
            }
        });
        editor = new Editor(null, "Alex", "alex@gmail.com", BigDecimal.TEN, true);
    }

    @Test
    public void Dado_um_editor_valido_Quando_criar_Entao_deve_retornar_um_id_de_cadastro() {
        Editor editorSalvo = cadastroEditor.criar(editor);
        assertEquals(1L, editorSalvo.getId());
        assertTrue(armazenamentoEditor.chamouSalvar);
    }

    @Test
    public void Dado_um_editor_null_Quando_criar_Entao_deve_retornar_exception() {
        assertThrows(NullPointerException.class, () -> cadastroEditor.criar(null));
        assertFalse(armazenamentoEditor.chamouSalvar);
    }

    @Test
    public void Dado_um_editor_com_email_existente_Quando_criar_Entao_deve_lancar_exception() {
        editor.setEmail("alex.existe@gmail.com");
        assertThrows(RegraNegocioException.class, () -> cadastroEditor.criar(editor));
    }

    @Test
    public void Dado_um_editor_com_email_existente_Quando_criar_Entao_nao_deve_salvar() {
        try {
            editor.setEmail("alex.existe@gmail.com");
            cadastroEditor.criar(editor);
        } catch (RegraNegocioException e) {}
        assertFalse(armazenamentoEditor.chamouSalvar);
    }
}