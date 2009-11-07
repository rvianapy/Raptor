/**
 * New BSD License
 * http://www.opensource.org/licenses/bsd-license.php
 * Copyright (c) 2009, RaptorProject (http://code.google.com/p/raptor-chess-interface/)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the RaptorProject nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package raptor.pref.page;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;

import raptor.Raptor;
import raptor.pref.PreferenceKeys;
import raptor.swt.chess.UserMoveInputMode;

public class ChessBoardBehaviorPage extends FieldEditorPreferencePage {

	public static final String[][] USER_MOVE_INPUT_MODE_ARRAY = {
			{ "Drag And Drop", UserMoveInputMode.DragAndDrop.toString() },
			{ "Click Click Move", UserMoveInputMode.ClickClickMove.toString() } };

	public ChessBoardBehaviorPage() {
		// Use the "flat" layout
		super(GRID);
		setTitle("Behavior");
		setPreferenceStore(Raptor.getInstance().getPreferences());
	}

	@Override
	protected void createFieldEditors() {
		addField(new ComboFieldEditor(
				PreferenceKeys.BOARD_USER_MOVE_INPUT_MODE, "Move input mode:",
				USER_MOVE_INPUT_MODE_ARRAY, getFieldEditorParent()));

		addField(new BooleanFieldEditor(
				PreferenceKeys.BOARD_TAKEOVER_INACTIVE_GAMES,
				"Inactive games can be taken over by new games",
				getFieldEditorParent()));

		addField(new BooleanFieldEditor(
				PreferenceKeys.BOARD_IS_SHOWING_PIECE_JAIL, "Show Piece Jail",
				getFieldEditorParent()));

		addField(new BooleanFieldEditor(
				PreferenceKeys.BOARD_IS_SHOW_COORDINATES, "Show Coordinates",
				getFieldEditorParent()));

		addField(new BooleanFieldEditor(
				PreferenceKeys.BOARD_PLAY_MOVE_SOUND_WHEN_OBSERVING,
				"Play Move Sound When Observing", getFieldEditorParent()));

		addField(new BooleanFieldEditor(
				PreferenceKeys.BOARD_IS_USING_CROSSHAIRS_CURSOR,
				"Invisible Move Enabled (Crosshairs cursor on drag and drops)",
				getFieldEditorParent()));

		addField(new BooleanFieldEditor(
				PreferenceKeys.BOARD_IS_SHOWING_PIECE_UNICODE_CHARS,
				"Show chess piece unicode chars (e.g. \u2654\u2655\u2656\u2657\u2658\u2659)",
				getFieldEditorParent()));

		addField(new BooleanFieldEditor(PreferenceKeys.BOARD_PREMOVE_ENABLED,
				"Premove Enabled", getFieldEditorParent()));

		addField(new BooleanFieldEditor(
				PreferenceKeys.BOARD_QUEUED_PREMOVE_ENABLED,
				"Queueing Premove Enabled", getFieldEditorParent()));

		addField(new BooleanFieldEditor(PreferenceKeys.BOARD_SMARTMOVE_ENABLED,
				"Smartmove Enabled (Middle Click)", getFieldEditorParent()));
	}
}
