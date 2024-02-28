DROP TABLE IF EXISTS section;
CREATE TABLE `section` (
                           `id` int(11) NOT NULL,
                           `name` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS joke;
CREATE TABLE `joke` (
                        `id` int(11) NOT NULL,
                        `section_idfs` int(11) NOT NULL,
                        `text` text COLLATE utf8_bin NOT NULL,
                        `rating` int(11) NOT NULL,
                        `creation_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;




--
-- Indizes für die Tabelle `joke`
--
ALTER TABLE `joke` ADD PRIMARY KEY (`id`);
ALTER TABLE `section` ADD PRIMARY KEY (`id`);
ALTER TABLE `joke` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
ALTER TABLE `section` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

