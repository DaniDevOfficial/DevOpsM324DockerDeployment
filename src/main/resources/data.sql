

INSERT INTO `section` (`id`, `name`) VALUES
(1, 'Flachwitze'),
(2, 'Schwarzer Humor');

INSERT INTO `joke` (`id`, `section_idfs`, `text`, `rating`, `creation_date`) VALUES
(1, 1, 'Kunde: \"Ich möchte Ihren Chef sprechen!\"\r\nSekretärin: \"Geht leider nicht, er ist nicht da!\"\r\nKunde: \"Ich hab ihn doch durchs Fenster gesehen!\"\r\nSekretärin: \"Er Sie auch!\"', 5, '2014-01-08 21:39:40'),
(2, 1, 'Der Verwaltungsrat zum CEO:\r\n\"Na, wie macht sich denn der neue Buchhalter?\"\r\nCEO: \"Toll, dieser Mann!\"\r\nVerwaltungsrat: \"Was kann er denn so besonderes?\"\r\nCEO: \"Er ist gelernter Friseur, er kann frisieren!\"', 3, '2014-01-08 21:42:41'),
(3, 1, 'Chef: \"Müller, Sie sind das beste Pferd in meinem Stall!\"\r\nMüller: \"Wirklich, Chef?\"\r\nChef: \"Ja, Sie machen den meisten Mist!\"', 5, '2014-01-08 21:43:20'),
(6, 2, 'Was steht auf dem Grabstein eines Mathematikers?\r\n\"Damit hat er nicht gerechnet.\"', 3, '2021-04-06 12:47:17');

